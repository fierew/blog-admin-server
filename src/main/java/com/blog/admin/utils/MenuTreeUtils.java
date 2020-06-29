package com.blog.admin.utils;

import com.blog.admin.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单树工具
 *
 * @author xuyang
 */
public class MenuTreeUtils {
    private final List<MenuModel> menuList;

    public MenuTreeUtils(List<MenuModel> menuList) {
        this.menuList = menuList;
    }

    //建立树形结构
    public List<MenuModel> buildTree() {
        List<MenuModel> treeMenus = new ArrayList<>();
        for (MenuModel menuNode : getRootNode()) {
            MenuModel childNode = buildChildTree(menuNode);
            treeMenus.add(childNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private MenuModel buildChildTree(MenuModel parentNode) {
        List<MenuModel> childMenus = new ArrayList<>();
        for (MenuModel menuNode : menuList) {
            if (menuNode.getParentId().equals(parentNode.getId())) {
                childMenus.add(buildChildTree(menuNode));
            }
        }
        parentNode.setChildren(childMenus);
        return parentNode;
    }

    //获取根节点
    private List<MenuModel> getRootNode() {
        List<MenuModel> rootMenuLists = new ArrayList<>();
        for (MenuModel menuNode : menuList) {
            if (menuNode.getParentId().equals(0)) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }
}
