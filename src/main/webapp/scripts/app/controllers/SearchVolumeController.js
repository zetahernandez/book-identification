define([ "require", "ember" ], 
		function() {
	var SearchVolumeController = Ember.ObjectController.extend({
		searchText : '',
		
		searchVolumes : function() {
			var volumes = BooksApp.Volume.find({q: this.get('searchText')});
			BooksApp.router.get('applicationController').connectOutlet({
				name : 'volumeList',
				context :volumes,
				outletName : 'center'
			});
		}
		
	});
	return SearchVolumeController;
});