# GithubMVP_Week6Day1
This is a refractor of Week4Day1 HW, using MVP

Create an application with two screens

Screen one: should have your Github profile. Use at least 4 fields from the response to update the views.

Screen 2: Populate the recyclerView with the repositories you get from your profile.

Use at least 3 fields in each item view.

NOTE - Currently, I am using OkHttp alongside an Eventbus. The issue is, an event bus can only register and unregister in an 
activity. For MVP, the logic should be in the presenter, which is a seperate class entirely. Thus, event buses cannot work. 
While my app does run, it does not follow proper MVP architecture. I will try to come back and redo it.

This is what the file structure looks like
![Screen Shot 2019-07-09 at 10 43 12 PM](https://user-images.githubusercontent.com/51377429/60936873-a64a5d00-a29c-11e9-927d-b16963f13059.png)

![Screenshot_20190709-224214](https://user-images.githubusercontent.com/51377429/60936882-aa767a80-a29c-11e9-9a4d-5f975e499b2b.jpg)

![Screenshot_20190709-224225](https://user-images.githubusercontent.com/51377429/60936895-b2361f00-a29c-11e9-95b8-34ea2ae23145.jpg)

