define([ "models/VolumeInfoModel" ], function(VolumeInfoModel) {
	var VolumeInfoListController = Ember.ArrayController.extend({
		init : function() {
			this._super();
		},
		showAll : function() {
			var volumes = VolumeInfoModel.create().find();
			return volumes;
		}
	});
	return VolumeInfoListController;
});