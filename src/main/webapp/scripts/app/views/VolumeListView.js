define([
	"ember",
	"text!templates/volumeInfoListTemplate.handlebars"
], function(Ember,volumesTemplate){
	var VolumeListView = Ember.View.extend({
	  template: Ember.Handlebars.compile(volumesTemplate),
	});
	return VolumeListView;
});
