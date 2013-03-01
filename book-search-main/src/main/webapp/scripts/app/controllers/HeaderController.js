define(["ember"], function (Ember) {
	var HeaderController = Ember.ArrayController.extend({
		needs: ['searchVolume']
	});

	return HeaderController;
});