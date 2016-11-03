# Trianglify
[![Build Status](https://travis-ci.org/manolovn/trianglify.svg?branch=master)](https://travis-ci.org/manolovn/trianglify)
[![Maven Central](https://img.shields.io/maven-central/v/com.manolovn/trianglify.svg)](https://maven-badges.herokuapp.com/maven-central/com.manolovn/trianglify)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Trianglify-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3014)

Android view inspired by http://qrohlf.com/trianglify/ 

<img src="./art/001.png " alt="Demo Screenshot" width="250" />

# Usage

Add the dependency

```groovy
dependencies {
    compile 'com.manolovn:trianglify:1.1.0'
}
```

Just add the view to your layout:

```xml
<com.manolovn.trianglify.TrianglifyView
            android:id="@+id/trianglify_view_sample"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
```

Cell size, variance, bleeds, color generator and point generator can be initialized from layout:

```xml
<com.manolovn.trianglify.TrianglifyView
            android:id="@+id/trianglify_view_sample"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            trianglify:cellSize="175"
            trianglify:variance="75"
            trianglify:bleedX="50"
            trianglify:bleedY="50"
            trianglify:colorGenerator="com.sample.color.MyCoolColorGenerator"
            trianglify:pointGenerator="com.sample.color.MyCoolPointGenerator"/>
```

or using setters (see sample for more info):

```java
trianglifyView.getDrawable().setCellSize(175);
trianglifyView.getDrawable().setVariance(75);
trianglifyView.getDrawable().setColorGenerator(new AnyColorGenerator());
trianglifyView.getDrawable().setPointGenerator(new AnyPointGenerator());
```

In the sample, you can find an example of ColorGenerator and an example of how to use differents types of PointGenerator. In the component are included two: RegularPointGenerator (for a grid distribution) and CircularPointGenerator (for a concentric circles distribution).

# License

    Copyright 2015 Manuel Vera Nieto

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
