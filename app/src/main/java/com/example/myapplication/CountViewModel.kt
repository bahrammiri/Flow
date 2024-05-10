import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class CountViewModel : ViewModel() {
    val count: MutableState<Int> = mutableIntStateOf(0)
    var isRunning1 = false
    fun counter() {
        if (!isRunning1) {
            isRunning1 = true
            viewModelScope.launch {
                for (i in 1..100) {
                    count.value++
                    delay(1000)
                }
                isRunning1 = false
            }
        }
    }

    var isRunning = false
    val count2: MutableState<Int> = mutableIntStateOf(0)
    fun counter2() {
        if (!isRunning) {
            isRunning = true
            viewModelScope.launch {
                delay(2000)
                count2.value++
                isRunning = false
            }
        }
    }


    val myFlow = flow() {
        for (i in 1..20) {
            emit(i)
            delay(1000)
        }
    }

    fun collectMyFlow(collectedValue: MutableState<Int>) {
        viewModelScope.launch {
            myFlow.collect {
                collectedValue.value = it


            }
        }
    }


}