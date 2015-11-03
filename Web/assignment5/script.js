$(function() {
    $('#cover').cycle({
       	fx:        'cover',
       	delay:    -2000,
		before: function(curr, next, opts) {
			opts.animOut.opacity = 0;
		}
    });
});