<img src="https://github.com/jisungbin/KeyboardBeautify/blob/master/art/keyboardbeautify-preview-compress.gif?raw=true" width="20%" align="right"/>

# KeyboardBeautify

Awesome keyboard animator that supports Android SDK 23 ✨

> This library was created based on the [android/user-interface-samples](https://github.com/android/user-interface-samples/tree/master/WindowInsetsAnimation).

# Preview

Come to YouTube for a smoother preview -> https://youtu.be/Sp9QJEopFp4

---

# Download [![](https://img.shields.io/maven-central/v/land.sungbin/keyboardbeautify)](https://search.maven.org/artifact/land.sungbin/keyboardbeautify)

```groovy
implementation "land.sungbin:keyboardbeautify:${version}"
```

# Usage

> VERY SIMPLE. JUST ONE LINE.

### Kotlin

Basic extension. Support SDK 23+.

```kotlin
Activity.keyboardBeautify(
    rootView: ViewGroup,
    inputLayout: ViewGroup,
    otherView: View? = null, // Optional, View to which animation is applied according to the state of the IME.
    editText: EditText // Automatically sets the EditText focusing to match the state of the IME.
)
```

### XML

Optional beautify. Support SDK 30+.

Automatically control the [IME](https://android-developers.googleblog.com/2009/04/updating-applications-for-on-screen.html) inset and visibility with nested scrolling of views.


```xml
<land.sungbin.keyboardbeautify.layout.InsetsAnimationLinearLayout />
<land.sungbin.keyboardbeautify.layout.InsetsAnimationConstraintLayout />
```

# Example

TODO

---

# Article (ko)

I am currently writing. Wait a minute!

# Happy Coding :)
