/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	var __weex_template__ = __webpack_require__(1)
	var __weex_style__ = __webpack_require__(2)
	var __weex_script__ = __webpack_require__(3)

	__weex_define__('@weex-component/8e2a728ca214c2831ef401b9169488f7', [], function(__weex_require__, __weex_exports__, __weex_module__) {

	    __weex_script__(__weex_module__, __weex_exports__, __weex_require__)
	    if (__weex_exports__.__esModule && __weex_exports__.default) {
	      __weex_module__.exports = __weex_exports__.default
	    }

	    __weex_module__.exports.template = __weex_template__

	    __weex_module__.exports.style = __weex_style__

	})

	__weex_bootstrap__('@weex-component/8e2a728ca214c2831ef401b9169488f7',undefined,undefined)

/***/ },
/* 1 */
/***/ function(module, exports) {

	module.exports = {
	  "type": "div",
	  "classList": [
	    "container"
	  ],
	  "children": [
	    {
	      "type": "div",
	      "children": [
	        {
	          "type": "text",
	          "attr": {
	            "value": "==================以下是native修改weex内容==============="
	          }
	        }
	      ]
	    },
	    {
	      "type": "div",
	      "children": [
	        {
	          "type": "mtext",
	          "attr": {
	            "tel": "123456",
	            "value": "123456"
	          },
	          "style": {
	            "width": 200,
	            "height": 100
	          }
	        }
	      ]
	    },
	    {
	      "type": "div",
	      "children": [
	        {
	          "type": "text",
	          "attr": {
	            "value": "==================以下是weex调用native==============="
	          }
	        }
	      ]
	    },
	    {
	      "type": "div",
	      "children": [
	        {
	          "type": "text",
	          "classList": [
	            "test"
	          ],
	          "events": {
	            "click": "click"
	          },
	          "attr": {
	            "value": "点我测试吐司"
	          }
	        }
	      ]
	    },
	    {
	      "type": "div",
	      "children": [
	        {
	          "type": "text",
	          "attr": {
	            "value": "==================以下是列表==============="
	          }
	        }
	      ]
	    },
	    {
	      "type": "div",
	      "classList": [
	        "cell"
	      ],
	      "children": [
	        {
	          "type": "image",
	          "classList": [
	            "thumb"
	          ],
	          "attr": {
	            "src": "drawable://ic_launcher"
	          }
	        },
	        {
	          "type": "text",
	          "classList": [
	            "title"
	          ],
	          "attr": {
	            "value": "JavaScript"
	          }
	        }
	      ]
	    },
	    {
	      "type": "div",
	      "classList": [
	        "cell"
	      ],
	      "children": [
	        {
	          "type": "image",
	          "classList": [
	            "thumb"
	          ],
	          "attr": {
	            "src": "http://t.cn/RGE3uo9"
	          }
	        },
	        {
	          "type": "text",
	          "classList": [
	            "title"
	          ],
	          "attr": {
	            "value": "Java"
	          }
	        }
	      ]
	    },
	    {
	      "type": "div",
	      "classList": [
	        "cell"
	      ],
	      "children": [
	        {
	          "type": "image",
	          "classList": [
	            "thumb"
	          ],
	          "attr": {
	            "src": "http://t.cn/RGE31hq"
	          }
	        },
	        {
	          "type": "text",
	          "classList": [
	            "title"
	          ],
	          "attr": {
	            "value": "Objective C"
	          }
	        }
	      ]
	    }
	  ]
	}

/***/ },
/* 2 */
/***/ function(module, exports) {

	module.exports = {
	  "test": {
	    "width": 200,
	    "height": 200,
	    "marginTop": 20,
	    "marginLeft": 20,
	    "fontSize": 50
	  },
	  "cell": {
	    "marginTop": 10,
	    "marginLeft": 10,
	    "flexDirection": "row"
	  },
	  "thumb": {
	    "width": 200,
	    "height": 200
	  },
	  "title": {
	    "textAlign": "center",
	    "flex": 1,
	    "color": "#808080",
	    "fontSize": 50
	  }
	}

/***/ },
/* 3 */
/***/ function(module, exports) {

	module.exports = function(module, exports, __weex_require__){"use strict";

	module.exports = {
	  methods: {
	    click: function click() {
	      __weex_require__('@weex-module/mModule').printLog("测试吐司!");
	    }
	  }
	};}
	/* generated by weex-loader */


/***/ }
/******/ ]);