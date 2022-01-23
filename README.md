<img src="https://github.com/jisungbin/KeyboardBeautify/blob/master/art/keyboardbeautify-preview-compress.gif?raw=true" width="20%" align="right"/>

# KeyboardBeautify

Awesome keyboard animator that supports Android SDK 21+ ✨

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

Basic extension. **Support SDK 21+.**

```kotlin
Activity.keyboardBeautify(
    rootView: ViewGroup,
    inputLayout: ViewGroup,
    otherView: View? = null, // Optional, View to which animation is applied according to the state of the IME.
    editText: EditText // Automatically sets the EditText focusing to match the state of the IME.
)
```

### XML

Optional beautify. **Support SDK 30+.**

Automatically control the [IME](https://android-developers.googleblog.com/2009/04/updating-applications-for-on-screen.html) insets and visibility with nested scrolling of views.


```xml
<land.sungbin.keyboardbeautify.layout.InsetsAnimationLinearLayout />
<land.sungbin.keyboardbeautify.layout.InsetsAnimationConstraintLayout />
```

# Example

You can see examples of using `Activity.keyboardBeauify` in the [app folder](https://github.com/jisungbin/KeyboardBeautify/blob/master/app/src/main/kotlin/land/sungbin/MainActivity.kt) of this project.

---

# Articles (ko)

1. [안드로이드 WindowInsets으로 키보드 애니메이션 구현하기 (1)](https://sungbin.land/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-windowinsets%EB%A1%9C-%ED%82%A4%EB%B3%B4%EB%93%9C-%EC%95%A0%EB%8B%88%EB%A9%94%EC%9D%B4%EC%85%98-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-1-b6452ed44bc8)
2. [안드로이드 WindowInsets으로 키보드 애니메이션 구현하기 (2)](https://sungbin.land/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-windowinsets%EC%9C%BC%EB%A1%9C-%ED%82%A4%EB%B3%B4%EB%93%9C-%EC%95%A0%EB%8B%88%EB%A9%94%EC%9D%B4%EC%85%98-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-2-fcfc87683401)
3. 안드로이드 WindowInsets으로 키보드 애니메이션 구현하기 (3): 작성 중

# Happy Coding :)
