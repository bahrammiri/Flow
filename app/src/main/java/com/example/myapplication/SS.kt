import android.util.Log
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun counter() {
    var count = mutableStateOf(0)
    CoroutineScope(Dispatchers.Main).launch {
        for (i in 1..100) {
            count.value++
            println("Count: ${count.value}")
            delay(1000)
        }
    }
}

fun main() {
    counter()

}


