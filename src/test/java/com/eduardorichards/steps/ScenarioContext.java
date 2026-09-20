package com.eduardorichards.steps;

import com.eduardorichards.pages.AbstractPage;

public class ScenarioContext {

    private AbstractPage currentPage;

    public AbstractPage getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(AbstractPage currentPage) {
        this.currentPage = currentPage; 
    }
}
