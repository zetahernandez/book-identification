define(["require", "ember", "ember_data"], function (require, Ember) {
	var IndustryIdentifier = DS.Model.extend({
		primaryKey: 'id',
		id: DS.attr('number'),
		identifier: DS.attr('string'),
		type: DS.attr('string')
	});
	return IndustryIdentifier;
});