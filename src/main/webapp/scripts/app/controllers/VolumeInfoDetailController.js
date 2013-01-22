define([ "require", "ember" ], function() {
	var VolumeInfoDetailController = Ember.ObjectController.extend({
		openPdf : function(event) {
			var volumeInfoId = event.context.get('id');
			console.log(volumeInfoId);
					window.open("rest/volumesInfo/open/" + volumeInfoId);
		}
	});
	return VolumeInfoDetailController;
});