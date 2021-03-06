// Copyright 2004-present Facebook. All Rights Reserved.

package com.facebook.react.uimanager;

import javax.annotation.Nullable;

import java.util.Locale;

import com.facebook.csslayout.CSSAlign;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.CSSFlexDirection;
import com.facebook.csslayout.CSSJustify;
import com.facebook.csslayout.CSSOverflow;
import com.facebook.csslayout.CSSPositionType;
import com.facebook.csslayout.CSSWrap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;

/**
 * Supply setters for base view layout properties such as width, height, flex properties,
 * borders, etc.
 *
 * Checking for isVirtual everywhere is a hack to get around the fact that some virtual nodes still
 * have layout properties set on them in JS: for example, a component that returns a <Text> may
 * or may not be embedded in a parent text. There are better solutions that should probably be
 * explored, namely using the VirtualText class in JS and setting the correct set of validAttributes
 */
public class LayoutShadowNode extends ReactShadowNode {

  @ReactProp(name = ViewProps.WIDTH, defaultFloat = CSSConstants.UNDEFINED)
  public void setWidth(float width) {
    if (isVirtual()) {
      return;
    }
    setStyleWidth(CSSConstants.isUndefined(width) ? width : PixelUtil.toPixelFromDIP(width));
  }

  @ReactProp(name = ViewProps.MIN_WIDTH, defaultFloat = CSSConstants.UNDEFINED)
  public void setMinWidth(float minWidth) {
    if (isVirtual()) {
      return;
    }
    setStyleMinWidth(
      CSSConstants.isUndefined(minWidth) ? minWidth : PixelUtil.toPixelFromDIP(minWidth));
  }

  @ReactProp(name = ViewProps.MAX_WIDTH, defaultFloat = CSSConstants.UNDEFINED)
  public void setMaxWidth(float maxWidth) {
    if (isVirtual()) {
      return;
    }
    setStyleMaxWidth(
      CSSConstants.isUndefined(maxWidth) ? maxWidth : PixelUtil.toPixelFromDIP(maxWidth));
  }

  @ReactProp(name = ViewProps.HEIGHT, defaultFloat = CSSConstants.UNDEFINED)
  public void setHeight(float height) {
    if (isVirtual()) {
      return;
    }
    setStyleHeight(
      CSSConstants.isUndefined(height) ? height : PixelUtil.toPixelFromDIP(height));
  }

  @ReactProp(name = ViewProps.MIN_HEIGHT, defaultFloat = CSSConstants.UNDEFINED)
  public void setMinHeight(float minHeight) {
    if (isVirtual()) {
      return;
    }
    setStyleMinHeight(
      CSSConstants.isUndefined(minHeight) ? minHeight : PixelUtil.toPixelFromDIP(minHeight));
  }

  @ReactProp(name = ViewProps.MAX_HEIGHT, defaultFloat = CSSConstants.UNDEFINED)
  public void setMaxHeight(float maxHeight) {
    if (isVirtual()) {
      return;
    }
    setStyleMaxHeight(
      CSSConstants.isUndefined(maxHeight) ? maxHeight : PixelUtil.toPixelFromDIP(maxHeight));
  }

  @ReactProp(name = ViewProps.FLEX, defaultFloat = 0f)
  public void setFlex(float flex) {
    if (isVirtual()) {
      return;
    }
    super.setFlex(flex);
  }

  @ReactProp(name = ViewProps.FLEX_GROW, defaultFloat = 0f)
  public void setFlexGrow(float flexGrow) {
    if (isVirtual()) {
      return;
    }
    super.setFlexGrow(flexGrow);
  }

  @ReactProp(name = ViewProps.FLEX_SHRINK, defaultFloat = 0f)
  public void setFlexShrink(float flexShrink) {
    if (isVirtual()) {
      return;
    }
    super.setFlexShrink(flexShrink);
  }

  @ReactProp(name = ViewProps.FLEX_BASIS, defaultFloat = 0f)
  public void setFlexBasis(float flexBasis) {
    if (isVirtual()) {
      return;
    }
    super.setFlexBasis(flexBasis);
  }

  @ReactProp(name = ViewProps.FLEX_DIRECTION)
  public void setFlexDirection(@Nullable String flexDirection) {
    if (isVirtual()) {
      return;
    }
    setFlexDirection(
        flexDirection == null ? CSSFlexDirection.COLUMN : CSSFlexDirection.valueOf(
            flexDirection.toUpperCase(Locale.US).replace("-", "_")));
  }

  @ReactProp(name = ViewProps.FLEX_WRAP)
  public void setFlexWrap(@Nullable String flexWrap) {
    if (isVirtual()) {
      return;
    }
    if (flexWrap == null || flexWrap.equals("nowrap")) {
      setFlexWrap(CSSWrap.NO_WRAP);
    } else if (flexWrap.equals("wrap")) {
      setFlexWrap(CSSWrap.WRAP);
    } else {
      throw new IllegalArgumentException("Unknown flexWrap value: " + flexWrap);
    }
  }

  @ReactProp(name = ViewProps.ALIGN_SELF)
  public void setAlignSelf(@Nullable String alignSelf) {
    if (isVirtual()) {
      return;
    }
    setAlignSelf(alignSelf == null ? CSSAlign.AUTO : CSSAlign.valueOf(
            alignSelf.toUpperCase(Locale.US).replace("-", "_")));
  }

  @ReactProp(name = ViewProps.ALIGN_ITEMS)
  public void setAlignItems(@Nullable String alignItems) {
    if (isVirtual()) {
      return;
    }
    setAlignItems(
        alignItems == null ? CSSAlign.STRETCH : CSSAlign.valueOf(
            alignItems.toUpperCase(Locale.US).replace("-", "_")));
  }

  @ReactProp(name = ViewProps.JUSTIFY_CONTENT)
  public void setJustifyContent(@Nullable String justifyContent) {
    if (isVirtual()) {
      return;
    }
    setJustifyContent(justifyContent == null ? CSSJustify.FLEX_START : CSSJustify.valueOf(
            justifyContent.toUpperCase(Locale.US).replace("-", "_")));
  }

  @ReactProp(name = ViewProps.OVERFLOW)
  public void setOverflow(@Nullable String overflow) {
    if (isVirtual()) {
      return;
    }
    setOverflow(overflow == null ? CSSOverflow.VISIBLE : CSSOverflow.valueOf(
            overflow.toUpperCase(Locale.US).replace("-", "_")));
  }

  @ReactPropGroup(names = {
      ViewProps.MARGIN,
      ViewProps.MARGIN_VERTICAL,
      ViewProps.MARGIN_HORIZONTAL,
      ViewProps.MARGIN_LEFT,
      ViewProps.MARGIN_RIGHT,
      ViewProps.MARGIN_TOP,
      ViewProps.MARGIN_BOTTOM,
  }, defaultFloat = CSSConstants.UNDEFINED)
  public void setMargins(int index, float margin) {
    if (isVirtual()) {
      return;
    }
    setMargin(ViewProps.PADDING_MARGIN_SPACING_TYPES[index], PixelUtil.toPixelFromDIP(margin));
  }

  @ReactPropGroup(names = {
      ViewProps.PADDING,
      ViewProps.PADDING_VERTICAL,
      ViewProps.PADDING_HORIZONTAL,
      ViewProps.PADDING_LEFT,
      ViewProps.PADDING_RIGHT,
      ViewProps.PADDING_TOP,
      ViewProps.PADDING_BOTTOM,
  }, defaultFloat = CSSConstants.UNDEFINED)
  public void setPaddings(int index, float padding) {
    if (isVirtual()) {
      return;
    }
    setPadding(
        ViewProps.PADDING_MARGIN_SPACING_TYPES[index],
        CSSConstants.isUndefined(padding) ? padding : PixelUtil.toPixelFromDIP(padding));
  }

  @ReactPropGroup(names = {
      ViewProps.BORDER_WIDTH,
      ViewProps.BORDER_LEFT_WIDTH,
      ViewProps.BORDER_RIGHT_WIDTH,
      ViewProps.BORDER_TOP_WIDTH,
      ViewProps.BORDER_BOTTOM_WIDTH,
  }, defaultFloat = CSSConstants.UNDEFINED)
  public void setBorderWidths(int index, float borderWidth) {
    if (isVirtual()) {
      return;
    }
    setBorder(ViewProps.BORDER_SPACING_TYPES[index], PixelUtil.toPixelFromDIP(borderWidth));
  }

  @ReactPropGroup(names = {
      ViewProps.LEFT,
      ViewProps.RIGHT,
      ViewProps.TOP,
      ViewProps.BOTTOM,
  }, defaultFloat = CSSConstants.UNDEFINED)
  public void setPositionValues(int index, float position) {
    if (isVirtual()) {
      return;
    }
    setPosition(
      ViewProps.POSITION_SPACING_TYPES[index],
      CSSConstants.isUndefined(position) ? position : PixelUtil.toPixelFromDIP(position));
  }

  @ReactProp(name = ViewProps.POSITION)
  public void setPosition(@Nullable String position) {
    if (isVirtual()) {
      return;
    }
    CSSPositionType positionType = position == null ?
        CSSPositionType.RELATIVE : CSSPositionType.valueOf(position.toUpperCase(Locale.US));
    setPositionType(positionType);
  }

  @Override
  @ReactProp(name = "onLayout")
  public void setShouldNotifyOnLayout(boolean shouldNotifyOnLayout) {
    super.setShouldNotifyOnLayout(shouldNotifyOnLayout);
  }
}
