define([ "require", "ember","models/Volume" ], function() {
	var VolumeListController = Ember.ArrayController.extend({
		init : function() {
			this._super();
		}
	});
	return VolumeListController;
});