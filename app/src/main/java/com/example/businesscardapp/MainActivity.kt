package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val image = painterResource(R.drawable._35363bb_3a9f_4e20_a8ba_674f496c3ff2)
                    val name = "Francesco Grauso"
                    val title = "Android App Developer"
                    val imageP = painterResource(R.drawable.icons8_telefono_90)
                    val phone = "+(39) 327 903 0132"
                    val imageS = painterResource(R.drawable.icons8_instagram_90)
                    val social = "@fra_grauso"
                    val imageE = painterResource(R.drawable.icons8_busta_cerchiata_90)
                    val email = "francescograuso@live.it"
                    BusinessCardApp(
                        image,
                        name,
                        title,
                        imageP,
                        imageS,
                        imageE,
                        phone,
                        social,
                        email
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(
    image: Painter,
    name: String,
    title: String,
    imageP: Painter,
    imageS: Painter,
    imageE: Painter,
    phone: String,
    social: String,
    email: String
) {
    Column(
        modifier = Modifier.background(Color.LightGray)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(2f)
        ) {
            Card(image = image, name = name, title = title)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f)
        ) {
            Info(
                imageP = imageP,
                imageS = imageS,
                imageE = imageE,
                phone = phone,
                social = social,
                email = email
            )
        }
    }

}

@Composable
fun Card(image: Painter, name: String, title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.DarkGray, RoundedCornerShape(10.dp))
        )

        Text(
            text = name,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun Info(
    imageP: Painter,
    imageS: Painter,
    imageE: Painter,
    phone: String,
    social: String,
    email: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        InfoLine(imageP, phone)
        InfoLine(imageS, social)
        InfoLine(imageE, email)
    }
}

@Composable
fun InfoLine(image: Painter, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(65.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(2f)
                .align(Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        val image = painterResource(R.drawable._35363bb_3a9f_4e20_a8ba_674f496c3ff2)
        val name = "Francesco Grauso"
        val title = "Android App Developer"
        val imageP = painterResource(R.drawable.icons8_telefono_90)
        val phone = "+(39) 327 903 0132"
        val imageS = painterResource(R.drawable.icons8_instagram_90)
        val social = "@fra_grauso"
        val imageE = painterResource(R.drawable.icons8_busta_cerchiata_90)
        val email = "francescograuso@live.it"
        BusinessCardApp(
            image,
            name,
            title,
            imageP,
            imageS,
            imageE,
            phone,
            social,
            email
        )
    }
}