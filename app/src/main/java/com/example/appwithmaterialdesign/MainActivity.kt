package com.example.appwithmaterialdesign

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appwithmaterialdesign.ui.theme.AppWithMaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppWithMaterialDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  MyDataApp()
                }
            }
        }
    }
}
@Composable
fun MyDataApp(){
    DataList(myDataList = DataResource().loadData())
}

@Composable
fun DataList( myDataList: List<PicturesData>, modifier: Modifier=Modifier){
    LazyColumn(modifier = modifier) {
        items(myDataList) { picturesData->
            DataCard(
                pictureData = picturesData,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}
@Composable
fun DataCard(pictureData : PicturesData, modifier: Modifier=Modifier) {
    Card(modifier = modifier
        .fillMaxSize()
        .height(200.dp)
        .background(
            shape= RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
            color = Color.LightGray,
        )
        .padding(16.dp)
    )
    {
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(pictureData.image),
                contentDescription = stringResource(pictureData.caption),
                modifier= Modifier
                    .fillMaxSize()
                    .height(134.dp),
                contentScale = ContentScale.Crop
            )

                Text(text = LocalContext.current.getString(pictureData.caption),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h4
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppWithMaterialDesignTheme {
       MyDataApp()
    }
}