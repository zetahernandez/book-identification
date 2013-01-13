define([
	"ember",
	"text!templates/volumeInfoDetailTemplate.handlebars"
], function(Ember,volumeInfoDetailTemplate){
	var VolumeInfoDetailView = Ember.View.extend({
	  template: Ember.Handlebars.compile(volumeInfoDetailTemplate)
	});
	return VolumeInfoDetailView;
});