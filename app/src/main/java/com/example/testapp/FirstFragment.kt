package com.example.testapp

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
open class FirstFragment : Fragment() {

    protected var name: String? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    protected fun test() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handlerThread = HandlerThread("myThread");
        handlerThread.start();
        val looper = handlerThread.getLooper()
        val mHandler = Handler(looper)
        mHandler.post(Runnable {

            Log.d("mylogs", "inside of runnable")
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Log.d("mylogs", "UI thread")
            } else {
                Log.d("mylogs", "background thread")
            }
        })

        val textView = view.findViewById<TextView>(R.id.textview_first)



        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}