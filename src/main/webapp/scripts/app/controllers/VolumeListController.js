define([ "require", "ember"], function(r,Ember) {
	var VolumeListController = Ember.ArrayController.extend({
		
		filterByCategory : function(categoryId) {
			Ember.Volumes.find({'categorId':categoryId });
		}.property()
	});
	return VolumeListController;
});