OFFICIAL PAGE
http://ivussnakes.sourceforge.net/

INSTALLATION
Just make .jar and put LiveWire.jar into Fiji plugins folder.


NEW FEATURES
- The LiveWire can't be run from the plugin anymore to avoid problems when
the LiveWire tool is used in other Toolsets.
- Fixed a memory leak.

Works with color: 
Now LiveWire is able to segment color images. This is done converting them to grayscale and then using the standard procedure (Thanks, Volker Bäcker!)

Run with macro: one can now use the following macro to use LiveWire
run ("LiveWire", "x0=50 y0=30 x1=95 y1=95 magnitude=43 direction=13 exponential=30 power=10");

Just go to Plugins->Macro->Record...
Then type the above macro, give it a name and press the "Create" button.
Now save the file and go to Plugins->Macro->Install... Then, choose the macro file you've just created.
There'll be a new menu under Plugins->Macro->"Your New Menu". Choose it to run the Macro. 
Make sure you've set the points inside the picture :)

New cost feature: Exponential
Now a new feature was added to cost. Basically, it gives more weight to paths that are over a low cost resultant gradient and paths over high gradients have less weight, being cheaper paths. This is done through the function:
fe = Math.exp(-pw*x)*fg;
where fe is the exponential cost and pw is the power parameter. Fg stands for the gradient magnitude cost (the one whose weight is affected by the "Magnitude" slider)
It works better if the other weights are set to zero (except for the "Power" one).

Better user interface:
Following code and opinions given by Volker Bäcker, the user interface is now better, so that the user is now able to finish segmentation through right-click and start another with left-click. To move points or add new points to the existing one, the user should press the keyboard shift key at the same time. 


HOW TO USE

After you installed the tool through the macro as pointed above, you'll be able to use the LiveWire tool.
Click on the part of the image you want to start selecting and wait a couple seconds. The LiveWire selection will automatically follow your mouse. When you are ready with the next point, click it and keep going. Right click to finish segmentation.
If you wanna start a new LiveWire, just finish the current one with the right-click and start a new one with the left-click.
To move existing points or add new points after you have finished the selection, hold shift and click the handles or click outside them to add new points.

Submit any bugs to danielbaggio@gmail.com

Thanks for using the tool.

AUTHOR

Daniel Lelis Baggio is a Computer Engineering graduated from Instituto Tecnologico de Aeronautica and has developed this tool at InCor - Instituto do Coracao

For full curriculum look at:
http://danielbaggio.blogspot.com
