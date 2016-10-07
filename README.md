[![](https://jitpack.io/v/vrjgamer/VImageButtonView.svg)](https://jitpack.io/#vrjgamer/VImageButtonView)

# VImageButtonView
####Custom Android ImageButton With embedded TextView.


## Getting Started

### Prerequisities
minimum sdk version should be API 10

### To Add this library

To add this library to your project, you need to follow the following steps: 

###  People using gradle

* Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
      allprojects {
    		repositories {
    			...
    			maven { url "https://jitpack.io" }
    		}
    	}
```
    
* Step 2. Add the dependency
```
      dependencies {
    	        compile 'com.github.vrjgamer:VImageButtonView:1.0'
    	}
```

###  People using maven

* Step 1. Add the JitPack repository to your build file
```
      <repositories>
    		<repository>
    		    <id>jitpack.io</id>
    		    <url>https://jitpack.io</url>
    		</repository>
    	</repositories>
    
```
  * Step 2. Add the dependency
```
      <dependency>
    	    <groupId>com.github.vrjgamer</groupId>
    	    <artifactId>VImageButtonView</artifactId>
    	    <version>1.0</version>
    	</dependency>
```


### How To Use: 

* To use this library in xml layouts add the following code:
```
	<com.vrjco.v.vimagebutton.VImageButtonView
       ...
		android:id="@+id/vim"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_centerInParent="true"
        android:background="@drawable/bg"
        android:gravity="center"
        android:scaleType="centerCrop"
        android:src="@drawable/button"
        android:text="Demo App"
        android:textColor="#f0f"
        android:textSize="13sp"
        app:imagePadding="20dp"
        app:overlay="#ff0000"
        app:overlayAlpha="0.2"
        app:textPadding="15dp" 
		
		...
		/>

```	

* For using the view in your activity; Make an instance of the VImageButtonView:

refer through an id

```
	{
		...
	
			 VImageButtonView imageButtonView = (VImageButtonView) findViewById(R.id.vim);
		...
	}
```

Or create view programmatically  

```
	{
		...
			VImageButtonView imageButtonView = new ImageButton(this);
		...
	}
```
* You can use following methods with the instance:

Text methods:

```
	{
		...
			textParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
			textParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
			
			//set embedded textView params
			 imageButtonView.setTextParams(textParams);
		
			//set text 
			imageButtonView.setText("TEXT");
			
			//set text size
			imageButtonView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
			
			//set text Padding 
			imageButtonView.setTextPadding(left, top, right, bottom);
			
			//set text gravity
			imageButtonView.setGravity(Gravity.CENTER);

			//set text color
			 imageButtonView.setTextColor(Color.BLACK);
		...
	}

```

ImageView methods:

```
	{
		...
			//set ImageView Background Color
			imageButtonView.setBackgroundColor(Color.BLACK);

			//set ImageView Background Resource
			imageButtonView.setBackgroundResource(R.drawable...);
		
			//set ImageView Source drawable
			imageButtonView.setImage(drawable);
			
			//set ImageView Source color
			imageButtonView.setImage(color);
			
			//set ImageView Source bitmap
			imageButtonView.setImage(bitmap);
			
			//set ImageView Source uri
			imageButtonView.setImage(uri);
			
			//set ImageView Source Scale Type
			imageButtonView.setScaleType(ScaleType.CENTER_CROP);

			//set ImageView Source Padding
			imageButtonView.setImagePadding(left, top, right, bottom);

		...
	}
```

ImageOverlay methods;

```
	{
		...
			//set Overlay Color
			imageButtonView.setImageOverlay(color);
			
			//set Overlay Alpha(0.0 < opacity < 1.0)
			imageButtonView.setImageOverlayAlpha(opacity);
			
			//remove Overlay
			imageButtonView.removeImageOverlay();
		...
	
	}

```

For any other query you can email {vrjgamer@gmail.com} or raise an issue.



