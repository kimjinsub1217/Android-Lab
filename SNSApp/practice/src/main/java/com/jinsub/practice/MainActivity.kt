package com.jinsub.practice

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jinsub.practice.Foo
import com.jinsub.practice.ui.theme.SNSAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val TAG = MainActivity::class.java.simpleName
    lateinit var foo: Foo

//    @UserQualifier(22, 177)
//    @Inject
//    lateinit var sub: User
//
//    @UserQualifier(23, 187)
//    @Inject
//    lateinit var jin: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.e(TAG,"1) ${sub.name}")
//        Log.e(TAG,"2) ${jin.name}")
//        assert(this::foo.isInitialized)

        setContent {
            SNSAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Inject
    fun injectFoo(
        @Named("foo1") foo: Foo
    ) {
        Log.e(TAG, "injectFoo : ${foo.id}")
        this.foo = foo
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SNSAppTheme {
        Greeting("Android")
    }
}