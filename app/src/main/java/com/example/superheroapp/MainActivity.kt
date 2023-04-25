package com.example.superheroapp

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.Size
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroapp.model.SuperHero
import com.example.superheroapp.model.heros

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme() {
                SuperHeroApp()
            }
        }
    }
}

@Composable
fun SuperHeroApp(){
    Scaffold(
        topBar = {
            SuperHeroAppTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)){
            items(heros){
                SuperHeroItem(superHero = it)
            }
        }
    }
}


@Composable
fun SuperHeroItem (
    superHero: SuperHero,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(74.dp),
        elevation = 2.dp
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            SuperHeroIcon(superHeroIcon = superHero.imageRes)
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                SuperHeroName(superName = superHero.nameRes)
                SuperHeroDescription(superHeroDescription = superHero.descriptionRes)
            }
        }
    }
}



@Composable
fun SuperHeroAppTopAppBar(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .size(54.dp),
        Arrangement.Center
    ){
        Text(text = stringResource(id = R.string.superHeroApp),
        style = MaterialTheme.typography.h1)
    }
}

@Composable
fun SuperHeroIcon (
    @DrawableRes superHeroIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp)),
        painter = painterResource(id = superHeroIcon),
        contentDescription = null
    )
}

@Composable
fun SuperHeroName (
    @StringRes superName: Int,
    modifier: Modifier = Modifier
){
    Text(text = stringResource(id = superName),
    style = MaterialTheme.typography.h3
    )
}

@Composable
fun SuperHeroDescription(
    @StringRes superHeroDescription: Int,
    modifier: Modifier = Modifier
){
    Text(text = stringResource(id = superHeroDescription),
    style = MaterialTheme.typography.body1)
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SuperHeroPreview(){
    SuperheroesTheme(darkTheme = false) {
        SuperHeroApp()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DarkThemePreview(){
    SuperheroesTheme(darkTheme = true) {
        SuperHeroApp()
    }
}
