define(["require", "ember", "ember_data"], function (require, Ember) {
	var IndustryIdentifier = DS.Model.extend({
		primaryKey: 'id',
		identifier: DS.attr('string'),
		type: DS.attr('string')
	});
	return IndustryIdentifier;
});