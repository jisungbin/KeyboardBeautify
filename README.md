# KeyboardBeautify

Awesome keyboard animator that supports Android SDK 23 ✨

> This library was created based on the [android/user-interface-samples](https://github.com/android/user-interface-samples/tree/master/WindowInsetsAnimation).

# Download [![](https://img.shields.io/maven-central/v/land.sungbin/keyboardbeautify)](https://search.maven.org/artifact/land.sungbin/keyboardbeautify)

```groovy
implementation "land.sungbin:keyboardbeautify:${version}"
```

---

# Preview

<img src="https://github.com/jisungbin/KeyboardBeautify/blob/master/art/keyboardbeautify-preview-compress.gif?raw=true" width="15%" />

Come to YouTube for a smoother preview -> https://youtu.be/Sp9QJEopFp4

# Usage

> VERY SIMPLE. JUST ONE LINE.

### Kotlin

Basic extension. Support SDK 23+.

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
