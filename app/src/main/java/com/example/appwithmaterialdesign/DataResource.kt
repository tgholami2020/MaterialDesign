package com.example.appwithmaterialdesign

class DataResource {

    fun loadData(): List<PicturesData>{
        return listOf<PicturesData>(
                PicturesData(R.string.caption1,R.drawable.sunpic),
                PicturesData(R.string.caption2,R.drawable.pic1),
                PicturesData(R.string.caption3,R.drawable.pic2),
                PicturesData(R.string.caption4,R.drawable.pic3),
                PicturesData(R.string.caption5,R.drawable.pic4),
                PicturesData(R.string.caption6,R.drawable.pic5)
        )
    }
}