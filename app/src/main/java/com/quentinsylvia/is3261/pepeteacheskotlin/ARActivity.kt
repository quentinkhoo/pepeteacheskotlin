package com.quentinsylvia.is3261.pepeteacheskotlin

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.core.TrackingState
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.activity_ar.*
import com.quentinsylvia.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import com.quentinsylvia.is3261.pepeteacheskotlin.PepeSharedPreferences.get
import android.graphics.Bitmap
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import java.util.*
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Canvas
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import java.io.*
import java.text.SimpleDateFormat


class ARActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment

    private var isTracking: Boolean = false
    private var isHitting: Boolean = false

    private val REQUEST_IMAGE = 100
    private lateinit var image: ImageView
    private var filePath: String = ""
    private lateinit var photoFile: File
    private lateinit var projectionManager: MediaProjectionManager

    lateinit var sharedPreferences: SharedPreferences

    private var arrayOfPepes = arrayOf("pepe obj.sfb", "pepe_glow.sfb", "pepe_green.sfb")

    private var uriString: String = "pepe obj.sfb"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)

        sharedPreferences = PepeSharedPreferences.defaultPrefs(this)

        image = findViewById<ImageView>(R.id.image)

        arFragment = sceneform_fragment as ArFragment

        // Adds a listener to the ARSceneView
        // Called before processing each frame
        arFragment.arSceneView.scene.addOnUpdateListener { frameTime ->
            arFragment.onUpdate(frameTime)
            onUpdate()
        }

        // Set the onclick lister for our button
        // Change this string to point to the .sfb file of your choice :)
        if (sharedPreferences.getBoolean("BasicQuizComplete", false) == true) {
            uriString = arrayOfPepes.get(1)
        }

        if (sharedPreferences.getBoolean("ControlFlowQuizComplete", false) == true) {
            uriString = arrayOfPepes.get(2)
        }

        floatingActionButton.setOnClickListener { addObject(Uri.parse(uriString)) }
        /*
        cameraButton.setOnClickListener { ;
            val bitmap = takescreenshot(window.decorView.rootView)
            image.setImageBitmap(bitmap)
            storeScreenshot(bitmap)

        }
        */
        showFab(false)
    }

    // Simple function to show/hide our FAB
    private fun showFab(enabled: Boolean) {
        if (enabled) {
            //cameraButton.isEnabled = true
            //cameraButton.visibility = View.VISIBLE
            floatingActionButton.isEnabled = true
            floatingActionButton.visibility = View.VISIBLE
        } else {
            //cameraButton.isEnabled = false
            //cameraButton.visibility = View.GONE
            floatingActionButton.isEnabled = false
            floatingActionButton.visibility = View.GONE
        }
    }

    // Updates the tracking state
    private fun onUpdate() {
        updateTracking()
        // Check if the devices gaze is hitting a plane detected by ARCore
        if (isTracking) {
            val hitTestChanged = updateHitTest()
            if (hitTestChanged) {
                showFab(isHitting)
            }
        }

    }

    // Performs frame.HitTest and returns if a hit is detected
    private fun updateHitTest(): Boolean {
        val frame = arFragment.arSceneView.arFrame
        val point = getScreenCenter()
        val hits: List<HitResult>
        val wasHitting = isHitting
        isHitting = false
        if (frame != null) {
            hits = frame.hitTest(point.x.toFloat(), point.y.toFloat())
            for (hit in hits) {
                val trackable = hit.trackable
                if (trackable is Plane && trackable.isPoseInPolygon(hit.hitPose)) {
                    isHitting = true
                    break
                }
            }
        }
        return wasHitting != isHitting
    }

    // Makes use of ARCore's camera state and returns true if the tracking state has changed
    private fun updateTracking(): Boolean {
        val frame = arFragment.arSceneView.arFrame
        val wasTracking = isTracking
        isTracking = frame.camera.trackingState == TrackingState.TRACKING
        return isTracking != wasTracking
    }

    // Simply returns the center of the screen
    private fun getScreenCenter(): Point {
        val view = findViewById<View>(android.R.id.content)
        return Point(view.width / 2, view.height / 2)
    }

    /**
     * @param model The Uri of our 3D sfb file
     *
     * This method takes in our 3D model and performs a hit test to determine where to place it
     */
    private fun addObject(model: Uri) {
        val frame = arFragment.arSceneView.arFrame
        val point = getScreenCenter()
        if (frame != null) {
            val hits = frame.hitTest(point.x.toFloat(), point.y.toFloat())
            for (hit in hits) {
                val trackable = hit.trackable
                if (trackable is Plane && trackable.isPoseInPolygon(hit.hitPose)) {
                    placeObject(arFragment, hit.createAnchor(), model)
                    break
                }
            }
        }
    }

    /**
     * @param fragment our fragment
     * @param anchor ARCore anchor from the hit test
     * @param model our 3D model of choice
     *
     * Uses the ARCore anchor from the hitTest result and builds the Sceneform nodes.
     * It starts the asynchronous loading of the 3D model using the ModelRenderable builder.
     */
    private fun placeObject(fragment: ArFragment, anchor: Anchor, model: Uri) {
        ModelRenderable.builder()
                .setSource(fragment.context, model)
                .build()
                .thenAccept {
                    addNodeToScene(fragment, anchor, it)
                }
                .exceptionally {
                    Toast.makeText(this@ARActivity, "Error", Toast.LENGTH_SHORT).show()
                    return@exceptionally null
                }
    }

    /**
     * @param fragment our fragment
     * @param anchor ARCore anchor
     * @param renderable our model created as a Sceneform Renderable
     *
     * This method builds two nodes and attaches them to our scene
     * The Anchor nodes is positioned based on the pose of an ARCore Anchor. They stay positioned in the sample place relative to the real world.
     * The Transformable node is our Model
     * Once the nodes are connected we select the TransformableNode so it is available for interactions
     */
    private fun addNodeToScene(fragment: ArFragment, anchor: Anchor, renderable: ModelRenderable) {
        val anchorNode = AnchorNode(anchor)
        // TransformableNode means the user to move, scale and rotate the model
        val transformableNode = TransformableNode(fragment.transformationSystem)
        transformableNode.renderable = renderable
        transformableNode.setParent(anchorNode)
        fragment.arSceneView.scene.addChild(anchorNode)
        transformableNode.select()
    }

    fun takescreenshot(v: View): Bitmap {
        v.isDrawingCacheEnabled = true
        v.buildDrawingCache(true)
        val b = Bitmap.createBitmap(v.drawingCache)
        v.isDrawingCacheEnabled = false
        return b
    }

    fun takescreenshotOfRootView(v: View): Bitmap {
        return takescreenshot(v.rootView)
    }

    fun storeScreenshot(bitmap: Bitmap) {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val filename = "IMG_" + timeStamp
        val path = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var out: FileOutputStream
        val imageFile = File(path, filename + ".jpg")

        out = FileOutputStream(imageFile)
        // choose JPEG format
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
        out.flush()
        out.close()
    }


}