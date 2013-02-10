define(["ember", "text!templates/volumeInfoTemplate.handlebars"], function (Ember, volumeInfoTemplate) {
	var VolumeInfoView = Ember.View.extend({
		template: Ember.Handlebars.compile(volumeInfoTemplate),

		init: function () {
			this._super();
			// The height of the content block when it's not expanded
			var adjustheight = 85;
			// The "more" link text
			var moreText = "+  More";
			// The "less" link text
			var lessText = "- Less";
			var moreless = $(".more-less");
			var id = "adjust-" + (moreless.length - 1);

			moreless = moreless[moreless.length - 1];

			// Sets the .more-block div to the specified height and hides any content that overflows
			$(".more-less .more-block").css('height', adjustheight).css('overflow', 'hidden');

			// The section added to the bottom of the "more-less" div
			$(moreless).append('<p class="continued">[&hellip;]</p><a href="#" class="adjust" id="' + id + '"></a>');

			$("a.adjust").text(moreText);

			$("#" + id).toggle(function () {
				var divFirst = $(this).parents("div:first");
				divFirst.find(".more-block").css('height', 'auto').slideDown(600).css('overflow', 'visible');
				// Hide the [...] when expanded
				divFirst.find("p.continued").css('display', 'none');

				$(this).text(lessText);
			}, function () {
				var divFirst = $(this).parents("div:first");
				divFirst.find(".more-block").slideDown(600).css('height', adjustheight).slideDown(600).css('overflow', 'hidden');
				divFirst.find("p.continued").css('display', 'block');
				$(this).text(moreText);
			});
		}
	});

	return VolumeInfoView;
});