define([
	"ember",
	"text!templates/volumeInfoTemplate.handlebars"
], function(Ember,volumeInfoTemplate){
	var VolumeInfoView = Ember.View.extend({
	  template: Ember.Handlebars.compile(volumeInfoTemplate)
	});
	return VolumeInfoView;
});
