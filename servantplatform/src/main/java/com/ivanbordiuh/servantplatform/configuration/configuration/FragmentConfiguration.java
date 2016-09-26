package com.ivanbordiuh.servantplatform.configuration.configuration;

import com.ivanbordiuh.servantplatform.configuration.util.DomainType;
import com.ivanbordiuh.servantplatform.servant.ServantFragment;

/**
 * Created by Ivan.Bordiuh on 20.06.2016.
 */
public class FragmentConfiguration {
    private Class<? extends ServantFragment> fragment;
    private DomainType[] domainTypes;
    private int layout;
    private int parentId;
    private boolean isRoot;

    public Class<? extends ServantFragment> getFragment() {
        return fragment;
    }

    public void setFragment(Class<? extends ServantFragment> fragment) {
        this.fragment = fragment;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setIsRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public DomainType[] getDomainType() {
        return domainTypes;
    }

    public void setDomainType(DomainType[] domainTypes) {
        this.domainTypes = domainTypes;
    }
}
