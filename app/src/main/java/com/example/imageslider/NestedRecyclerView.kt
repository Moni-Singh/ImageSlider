package com.example.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imageslider.R.*


class NestedRecyclerView : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private val parentList = ArrayList<ParentItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_nested_recycler_view)

        recyclerView = findViewById(R.id.monisingh)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        addDataToList()
        val adapter =ParentAdapter(parentList)
        recyclerView.adapter = adapter
    }
    private fun addDataToList(){
        val childitems1 =ArrayList<ChildItem>()

        childitems1.add(ChildItem("moni",R.drawable.cat))
        childitems1.add(ChildItem("soni",R.drawable.princes))
        childitems1.add(ChildItem("tutu",R.drawable.story))
        childitems1.add(ChildItem("kuku",R.drawable.cat))



        parentList.add(ParentItem("ToolsKids",R.drawable.coco,childitems1))

        val childitems2 =ArrayList<ChildItem>()

        childitems2.add(ChildItem("moni",R.drawable.cat))
        childitems2.add(ChildItem("moni",R.drawable.princes))
        childitems2.add(ChildItem("moni",R.drawable.story))
        childitems2.add(ChildItem("moni",R.drawable.cat))
        parentList.add(
            ParentItem(
                "Mother",
                R.drawable.cat,
                childitems2)

        )


    }
}