package com.kalyani.kotlinroom.todo

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.kalyani.kotlinroom.R
import com.kalyani.kotlinroom.maze.ui.Maze
import es.dmoral.toasty.Toasty
import java.util.*

class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {


    override fun doWork(): Result {
        Handler(Looper.getMainLooper()).post {
 Toasty.success(applicationContext, "success", Toasty.LENGTH_LONG).show()
            var intent = Intent(applicationContext, Maze::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            applicationContext.startActivity(intent)
            Log.d("values", "success")
            val notificationBuilder = NotificationCompat.Builder(applicationContext,"one")
                .setSmallIcon(R.drawable.ic_check_white_24dp)
  
                .setContentTitle("Title: API LEVEL " + Build.VERSION.SDK_INT)
                .setContentText("UUID: " + UUID.randomUUID())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(applicationContext)){
                notify(1, notificationBuilder.build())
            }

 }

        return Result.success()
    }
}