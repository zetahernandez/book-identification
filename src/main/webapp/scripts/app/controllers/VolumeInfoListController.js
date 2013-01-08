define([ "models/VolumeInfoModel" ], function(VolumeInfoModel) {
	var VolumeInfoListController = Em.ArrayController.create({
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