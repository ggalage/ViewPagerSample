# ViewPagerSample
viewpager sample. only loads one page at start and defers other page loading until user swipes to them.

Default design of View Pager may result in longer initial loading time and unnecessary server requests 
especially when there are many images that need to be downloaded and loaded on your screen.  This is because ViewPagers need to have at least the adjacent 
screens to be preloaded for it to show the swiping animation.  You can initialize adjacent page's view with a loading indicator and then
update them with your content when the user swipes to them. 

*In order to survive orientation change, you need to override instantiateItem method on PagerAdapter and re-establish connection between
each of pager screens with its parent.

This sample uses Mosby and Conductor.
