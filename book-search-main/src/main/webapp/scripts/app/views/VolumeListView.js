define(["ember", "text!templates/volumeInfoListTemplate.handlebars", "jquery"], function (Ember, volumesTemplate, $) {
	var VolumeListView = Ember.View.extend({
		defaultTemplate: Ember.Handlebars.compile(volumesTemplate)
	});
	return VolumeListView;
});