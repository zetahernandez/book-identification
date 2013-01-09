define([
	"ember",
	"text!templates/volumeInfoListTemplate.handlebars"
], function(Ember,volumesTemplate){
	var VolumeInfoListView = Ember.View.extend({
	  template: Ember.Handlebars.compile(volumesTemplate)
	});
	return VolumeInfoListView;
});
