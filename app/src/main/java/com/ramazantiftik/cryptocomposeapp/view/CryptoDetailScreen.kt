package com.ramazantiftik.cryptocomposeapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.ramazantiftik.cryptocomposeapp.model.Crypto
import com.ramazantiftik.cryptocomposeapp.util.Resource
import com.ramazantiftik.cryptocomposeapp.viewmodel.CryptoDetailViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition", "ProduceStateDoesNotAssignValue")
@Composable
fun CryptoDetailScreen(
    id: String,
    price: String,
    navController: NavController,
    viewModel: CryptoDetailViewModel = hiltViewModel()
){

    //Step 1 -> Wrong
    /*
    val scope = rememberCoroutineScope()

    var cryptoItem : Resource<Crypto> = Resource.Loading()

    var cryptoItem by remember {
        mutableStateOf<Resource<Crypto>>(Resource.Loading())
    }


    scope.launch {
        cryptoItem=viewModel.getCrypto(id)
        println(cryptoItem.data)
    }
     */

    /*
    var cryptoItem by remember {
        mutableStateOf<Resource<Crypto>>(Resource.Loading())
    }

    LaunchedEffect(key1 = Unit) {
        cryptoItem=viewModel.getCrypto(id)
        println(cryptoItem.data)
    }
     */

    val cryptoItem= produceState<Resource<Crypto>>(initialValue = Resource.Loading()) {
        value=viewModel.getCrypto(id)
        println(value.data)
    }.value



    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.secondary),
    contentAlignment = Alignment.Center) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            when(cryptoItem){

                is Resource.Success -> {
                    val selectedCrypto = cryptoItem.data!![0]
                    
                    Text(text = selectedCrypto.name,
                        style = MaterialTheme.typography.h3,
                        modifier =Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary,
                        textAlign = TextAlign.Center
                        )

                    Image(
                        painter = rememberImagePainter(data = selectedCrypto.logo_url),
                        contentDescription = selectedCrypto.name,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(200.dp, 200.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                    
                    Text(text = price,
                        style = MaterialTheme.typography.h4,
                        modifier =Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center
                    )
                }

                is Resource.Loading -> {
                    CircularProgressIndicator(color = MaterialTheme.colors.primary)
                }

                is Resource.Error -> {
                    Text(text = cryptoItem.message!!)
                }

            }

        }

    }

}