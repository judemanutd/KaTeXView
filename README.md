# Katex View

[![Download](https://api.bintray.com/packages/jude-manutd/maven/katexview/images/download.svg) ](https://bintray.com/jude-manutd/maven/katexview/_latestVersion)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg?style=flat-square)](https://opensource.org/licenses/MIT) 
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

A library that uses [Khan Academy Katex](https://github.com/KaTeX/KaTeX) for TeX math rendering.

## Usage

### Gradle

Add this to your module's build.gradle file:

```groovy

dependencies {
    // ... other dependencies
    implementation 'com.github.judemanutd:katexView:1.0.1'
}

```

### Maven

```xml

<dependency>
  <groupId>com.github.judemanutd</groupId>
  <artifactId>katexView</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>

```
__________

Include the following code in your xml layout

```xml
<com.judemanutd.katexview.KatexView
    android:id="@+id/katex_text"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:textColor="@color/colorPrimary" />
```

You can then supply the text to be rendered in kotlin or java

```kotlin

val text = "$$ c = \\pm\\sqrt{a^2 + b^2} $$"
katex_text.setText(text)

```

<img src="https://raw.githubusercontent.com/judemanutd/KatexView/master/example.png" />

## Supported Attributes

All webview attributes are automatically inherited, in addition to that, the following can be customized 
- `color` 
    - can be specified in xml using the `textColor` attribute
    - can be used in code by calling the `setTextColor` on the `KatexView`
- `text size` - _coming soon_
