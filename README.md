# KeyboardBeautify

Awesome keyboard animator that supports Android SDK 23 ✨

# Download [![](https://img.shields.io/maven-central/v/land.sungbin/keyboardbeautify)](https://search.maven.org/artifact/land.sungbin/keyboardbeautify)

```groovy
implementation "land.sungbin:keyboardbeautify:${version}"
```

---

# Preview

todo

# Usage

> VERY SIMPLE. JUST ONE LINE.

### Kotlin

Basic extensions. Support SDK 23+

```kotlin
Activity.keyboardBeautify(
    rootView: ViewGroup,
    inputLayout: ViewGroup,
    otherView: View? = null, // optional,
    editText: EditText
)
```

### XML

Optional beautify. Support SDK 30+.

Automatically control the IME inset and visibility with nested scrolling of views.


```xml
<land.sungbin.keyboardbeautify.layout.InsetsAnimationLinearLayout />
<land.sungbin.keyboardbeautify.layout.InsetsAnimationConstraintLayout />
```

---

# Happy Coding :)
