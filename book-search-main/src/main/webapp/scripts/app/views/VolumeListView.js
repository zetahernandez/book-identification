define(["ember", "text!templates/volumeInfoListTemplate.handlebars"], function (Ember, volumesTemplate) {
	var VolumeListView = Ember.View.extend({
		template: Ember.Handlebars.compile(volumesTemplate),

		init : function() {
			this._super();
			this.rerender();
		}
	});
	return VolumeListView;
});