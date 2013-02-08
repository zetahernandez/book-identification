define(["require", "ember"], function () {
	var VolumeInfoDetailController = Ember.ObjectController.extend({
		openPdf: function (event) {
			var volumeInfoId = event.context.get('id');
			console.log(volumeInfoId);
			window.open("rest/volumesInfo/open/" + volumeInfoId);
		},

		back: function () {
			BooksApp.router.get('volumeListController').contentChanged();
			BooksApp.router.applicationController.connectOutlet({
				name: 'volumeList',
				context: BooksApp.router.volumeListController.content,
				outletName: 'center'
			});
		}
	});
	return VolumeInfoDetailController;
});