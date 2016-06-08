# kotlin-vs-java
#####A simple example to show Kotlin vs Java code in Android

See [MainActivity](app/src/main/kotlin/com/basecamp/kotlin/activities/MainActivity.kt) vs [MainActivityJava](app/src/main/java/com/basecamp/kotlin/activities/MainActivityJava.java) to compare funtionally equivalent implementations of an activity with some very basic animations. This example demonstrations how Kotlin [extensions](https://kotlinlang.org/docs/reference/extensions.html), [higher-order functions](https://kotlinlang.org/docs/reference/lambdas.html), and [Anko](https://github.com/Kotlin/anko/blob/master/doc/ADVANCED.md) combine to provide really powerful features with concise syntax.

Provided are examples of [`View` extensions](app/src/main/kotlin/com/basecamp/kotlin/extensions/ViewExtension.kt), [`Animator` extensions](app/src/main/kotlin/com/basecamp/kotlin/extensions/AnimatorExtension.kt), and [`Context` extensions](app/src/main/kotlin/com/basecamp/kotlin/extensions/ContextExtension.kt). Additionally, there are examples of using [single-line functions and higher-order functions](app/src/main/kotlin/com/basecamp/kotlin/helpers/AndroidHelper.kt).

Here's the content of the Kotlin [MainActivity](app/src/main/kotlin/com/basecamp/kotlin/activities/MainActivity.kt) for convenience:
```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.backgroundCircle(R.color.colorAccent)

        runDelayed(2000) { button.alphaAnimator(0f, 1f, 500).start() }
        atleastLollipop { button.onClick { reveal() } }
    }

    fun reveal() {
        overlay.circularRevealAnimator(centerX(), centerY(), 300)
            .animationEnd { button.onClick { hide() } }
            .start()
    }

    fun hide() {
        overlay.circularHideAnimator(centerX(), centerY(), 300)
            .animationEnd { button.onClick { reveal() } }
            .start()
    }

    fun centerX() = overlay.width / 2

    fun centerY() = overlay.height / 2
}
```
