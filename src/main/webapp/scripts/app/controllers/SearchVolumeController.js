define([ "require", "ember" ], function() {
	var SearchVolumeController = Ember.ObjectController.extend({
		searchText : '',
		search : function() {
			console.log('search for %@'.fmt(this.get('searchText')));
		}
	});
	return SearchVolumeController;
});