package kz.test.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flutterEngine = FlutterEngine(this)
        flutterEngine
            .dartExecutor
            .executeDartEntrypoint(DartEntrypoint.createDefault())
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)

        val intent = FlutterActivity
            .withCachedEngine("my_engine_id")
            .build(this)
        startActivity(intent)
    }
}
