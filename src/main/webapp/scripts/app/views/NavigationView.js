define([ "ember", ], function(Ember) {
	var NavigationView = Ember.View.extend({
		tagName: 'ul',
		classNames: ['navigation']
	});
	return NavigationView;
});
