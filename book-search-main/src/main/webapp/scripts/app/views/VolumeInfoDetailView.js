define(["ember", "text!templates/volumeInfoDetailTemplate.handlebars"], function (Ember, volumeInfoDetailTemplate) {
	var VolumeInfoDetailView = Ember.View.extend({
		defaultTemplate: Ember.Handlebars.compile(volumeInfoDetailTemplate),
		didInsertElement: function () {
			Ember.$('html, body').animate({
				scrollTop: 0
			}, 2000);
		}
	});
	return VolumeInfoDetailView;
});