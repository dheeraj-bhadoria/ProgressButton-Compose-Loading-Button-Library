
# Progress Button or Loadign Button

### About Progress Button or Loading Button 

This button itself show the progress dialog inside the button. You can use it in the following conditions - 
1. To show user something operating in backgorund
2. You can show loading until you are waiting for the APIs.
3. You can customize the button accroding to your requirements like Background Color, Foreground Color, Width, Height.

## About me

Hi, I am [**Dheeraj Singh Bhadoria**](https://dheeruapps.in), Mobile Applicaiton Developer. I am passionate about sharing knowledge through open-source, blogs, and videos.

## Using Progress Button in your application

Add this in your build.gradle
```groovy
implementation 'com.github.dheeraj-bhadoria:ProgressButton-Compose-Loading-Button-Library:0.0.1'
```

How to use this  :
```kotlin
 ProgressButton(
            text = "Submit",
            backgroundColor = Color.Blue,
            foregroundColor = Color.White,
            buttonHeight = 50.dp,
            buttonWidth = 200.dp,
            onButtonClicked = {
                isLoading = true;
            },
            isLoading = isLoading
        )
```
After Completion of task you can stop loading. In following example i have disable loading after 2 seconds :
```kotlin
    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000) // delay for 2 seconds
            // execute your statement here
            // for example, show a Toast message
            isLoading = false;
        }
    }
```



