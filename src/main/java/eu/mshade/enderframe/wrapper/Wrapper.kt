package eu.mshade.enderframe.wrapper

abstract class Wrapper<I, O>: Mapper<I, O> {

    private val outputByInput: MutableMap<I, O> = mutableMapOf()
    private val inputByOutput: MutableMap<O, I> = mutableMapOf()

    fun map(input: I): O? = outputByInput[input]

    fun reverseMap(output: O): I? = inputByOutput[output]

    fun register(input: I, output: O) {
        inputByOutput[output] = input
        outputByInput[input] = output
    }

    fun registerMapping(input: I, output: O) {
        outputByInput[input] = output
    }

    fun registerReverseMapping(input: I, output: O) {
        inputByOutput[output] = input
    }
}