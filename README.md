# MaterialTextField

A different beautiful Floating Edit Text

[![screen](https://raw.githubusercontent.com/florent37/MaterialTextField/master/screens/2_small.png)](https://www.youtube.com/watch?v=Rax_o3URazU)

[![screen](http://i.giphy.com/l41lVkA0YkaZWNT0I.gif)](https://www.youtube.com/watch?v=Rax_o3URazU)

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.materialtextfield.sample">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

#Usage

Surround your EditText by a MaterialTextField

```xml
<com.github.florent37.materialtextfield.MaterialTextField
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        app:mtf_image="@drawable/ic_mail_grey600_24dp"
        >

        <EditText
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:textColor="#333"
             android:textColorHint="#666"
             android:textSize="15sp" />

</com.github.florent37.materialtextfield.MaterialTextField>

```

Don't forget to precise a drawable to **mtf_image**

```xml
app:mtf_image="@drawable/ic_mail_grey600_24dp"
```

#Available attributes

```xml
<com.github.florent37.materialtextfield.MaterialTextField
    android:layout_width="match_parent"
    android:layout_height="wrap_content"

    app:mtf_image="@drawable/ic_mail_grey600_24dp"
    app:mtf_animationDuration="1000"
    app:mtf_cardColor="@color/cardview_dark_background"
    app:mtf_labelColor="@android:color/holo_red_dark"
    app:mtf_openKeyboardOnFocus="true">
```

#Download

In your module [![Download](https://api.bintray.com/packages/florent37/maven/MaterialTextField/images/download.svg)](https://bintray.com/florent37/maven/HollyViewPager/_latestVersion)
```groovy
compile 'com.github.florent37:materialtextfield:1.0.0@aar'
compile 'com.android.support:cardview-v7:22.2.1'
compile 'com.nineoldandroids:library:2.4.0'
```

#Credits

Author: Florent Champigny

<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/profile/view?id=297860624">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>

Designer: Srikant Shetty

Originally designed on MaterialUp : [http://www.materialup.com/posts/new-material-text-fields-application](http://www.materialup.com/posts/new-material-text-fields-application)

<a href="www.dribbble.com/srikant">
  <img alt="Follow me on Dribble"
       src="http://icons.iconarchive.com/icons/graphics-vibe/classic-3d-social/72/dribbble-icon.png" />
</a>


License
--------

    Copyright 2015 florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
